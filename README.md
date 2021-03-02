# 2020-2학기 웹서버프로그래밍 최종프로젝트

### 프로젝트 주제 : 코로나 종합 포털

### 개발환경
* 프레임워크 : Spring Boot 
* OS : macOS 
* IDE : Intelij 
* 템플릿 엔진 : jsp 
* 데이터베이스 : h2database( db 테스트 용 메모리 사용) + MySQL  
* 프레임워크 ORM : JPA 
* 로그 관리 : slf4j, log4j 
* test : Junit5 ( 라이브러리 디버깅용도로 사용 ) 
* build tool : Gradle 

### 구현할 기능 설계 
* 회원가입, 로그인, 로그아웃 ( session + db ) 
* 게시판 글쓰기 읽기, 수정, 삭제 조회수 ( CRUD ) 
* 회원가입 중복 방지 서비스 구현 
* 세션 기반으로 페이지를 볼수 있는 권한 ( session, jsp bean scope +  interceptor ) 
* 구글맵 지도( googleMap api, script ) 
* 공공데이터 코로나 정보 api db ( db, api , json, xml 수신 및 저장 통신 파싱 ) 
* db에서 코로나 정보 가져와 보여주기 ( db, sql ) 
* 공지사항, 등록 댓글 쓰기 ( 서비스 구현 )
* 화면 공통 템플릿 ( bootstrap, css, html ) 
* 에러 발생에 대비한 에러페이지 구현 ( jsp ) 

### Project 진행 내용
#### 1) servelt / jsp / controller
* 이 프로젝트에서는 Servelt을 직접 구현하여 작동하는 페이지 페이지를, jsp 통해 실행하는 페이지를, controller 이용하는 페이지를 모두 구현해보았다.
* Servelt에서 URI를 매핑하는 것은 크게 2가지 방식으로 할 수 있는데 Web.xml에서 mapping경로를 지정해주는 방식과 어노테이션 방식이 있다.
* Servelt Controller는 Spring MVC 를 구현하는 의 라이브러리중 하나이며 나중에 결국 servlet코드로 변환되어 실행된다.
* 또한 jsp파일은 서버에서 역할을 할때 Servelt 코드로 변환되게 된다.

###### 서블릿 페이지를 직접 작성
```java
@WebServlet(urlPatterns = "/googleMap")
public class GoogleMapServlet extends HttpServlet {
Logger logger = LoggerFactory.getLogger(GoogleMapServlet.class);

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```
###### jsp를 이용해 페이지 생성
```jsp
<page%@ language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<html>
  <head>
    <title>코로나 종합 19(covid19) 포털 사이트</title>
    <!-- meta -->
    <meta charset="UTF-8">
  </head>
</html>
```
###### Controller를 통해
```java
@Controller
public class MemberController {
  @GetMapping("/member/join")
  public String join() {
      return "member/join";
   }
}
```
#### 2) jdbc / JPA  / Spring Data Jpa
* 이 프로젝트에서 데이터베이스에 연결하고 통신하는 방법에는 크게 3가지가 있다
* jdbc는 MySQL DB에 근접 할 수 있게 자바에서 제공하는 API 이다
* JPA는 jdbc API를 이용해 만들어낸 ORM 기술이다. ORM 기술이란 기존의 SQL과 Java Object 사이에 매핑을 해주는 기술이다.
과 Java Object 사이에 매핑을 해주는 기술이다.
* Spring Data JPA는 JPA 기술을 발전시켜 개발자들이 자주 사용하는 공통적인 쿼리문들을 통합하여 만든 라이브러리이다.
* Spring Data JPA 인터페이스를 구현하기만해도 기본적인 CRUD를 모두 사용 할 수 있어 생산성이 매우 뛰어나다.
* 비슷한 기능을 하는 코드이지만 발전된 기술을 사용 할 수록 확실히 코드의 길이가 줄어드는 것을 확인 할 수 있다.

###### jdbc를 통해 직접 연결
```java
public int login(String user_id, String user_password) {
  try {
       PreparedStatement pst = con.prepareStatement("SELECT user_password FROM member WHERE user_id = ?");
       pst.setString(1, user_id);  
       rs = pst.executeQuery();
       if (rs.next()) {
            return rs.getString(1).equals(user_password) ? 1 : 0;
       } else {
            return -2;
       }
  } catch (Exception e) {
         e.printStackTrace();
            return -1;
      }
 }
```
###### JPA를 이용
```java
public Detail getDetailFromStateDt(int stateDt) {
  try {
      return em.createQuery("select d from Detail d where d.stateDt = :stateDt", Detail.class)
                .setParameter("stateDt", stateDt).getSingleResult();
      } catch (NoResultException nre) {
            return null;
      }
  }
```
###### Spring Data Jpa를 이용
```java
public interface BbsRepository extends JpaRepository<Bbs, Long> {
    Page<Bbs> findByStatus(Status status, Pageable pageable);
}
```
#### 3) 로그인 session check 확인을 위한 방법
* 이 프로젝트에서는 jsp 페이지를 로드하는 시점에 해당 파일을 하여 include 이와 같은 방식으로 세션을 확인하여 로그인 체크를 하고 있다.

```jsp
<%@ include file="/member/memberSessionCheck.jsp" %>
<%
    String userId = (String) session.getAttribute("user_id");
    if (userId == null) {
%>
<script>
    alert("이용하기 위해 로그인이 필요합니다.");
    location.href = "/member/login";
</script>
<%
    }
%>
```

* 아래와 같이 HandlerInterceptor 를 구현하여 interceptor를 만들 수 있다. 
인터셉터는 컨트롤러가 로드되기 전 시점에 실행되기 때문에 사실, 세션체크의 경우 인터셉터를 이용하는 것이 좀 더 목적에 맞다고 할 수 있다 하지만.
수업에 나왔던 JSP include 태그인 태그를 사용해보기 위한 목적으로 위와 같이 작성하였다.

```java
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
  }
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
  }
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
  }
}
```

###### 4) jsp bean / DTO / Spring bean
* jsp bean은 자바코드로 작성된 클래스 파일의 일종인데 에서 , jsp 사용되는 형태를 보면 DTO VO 나 와 비슷한 역할을 한다고도 할 수 있다.
* VO와 DTO entity 의 공통점은 클래스의 일부 혹은 전체 맴버와 게터와 세터를 포함하는 클래스라고 할 수 있다.jsp bean역시 VO DTO 와 의 역할을 하면서 scope를 가진다.
* 프로젝트를 진행하면서 jsp bean, Spring bean 이름이 비슷한 두가지에 대한 차이점을 알아보았다.
* Spring bean은 ioc 스프링 컨테이너에 등록되어 있는 객체라고 말할 수 있다. Spring bean에도 jsp bean과 같이 비슷한 용어인 scope를 가지는데 이는 싱글톤으로 관리 되는지 아닌지를 나타내는 옵션이다.
* 결론을 말하자면 jsp bean은 DTO 로 대체되어 사용 될 수 있고, Spring bean과는 전혀 다른 의미를 지닌다.

###### DTO 클래스 사용
```java
public class BbsCommentDTO {
    private String content;
    private String date;
    private String username;
}
```

###### Spring bean 으로 등록
```java
@Configuration
public class ServletRegistrationConfig {
    @Bean
    public ServletRegistrationBean googleMapBean() {
      // googleMap Servlet -> Spring bean으로 등록
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new  GoogleMapServlet());
        registrationBean.addUrlMappings("/googleMap");
        return registrationBean;
     }
}
```

### 프로젝트 동작 방법 및 발표자료 주소

* [구글드라이브 주소](https://drive.google.com/drive/folders/1NOjGZrmlvrKIPpITjF0xZ8sXUTfBY0SQ)
* 설치 및 실행방법 
1) 구글드라이브 혹은 깃 허브에서 소스코드를 내려 받는다.
2) Intellij에서 프로젝트를 불러온다 를 . ( eclipse 사용하면 오작동 할 수 있음.)
3) mysql 서버를 작동시킨다. ( url : localhost:3306/demo_test, username : root, password : 1004 )
4) src/main/java/DemoApplication run 파일을 시킨다.
5) localhost:8080로 접속한다.
