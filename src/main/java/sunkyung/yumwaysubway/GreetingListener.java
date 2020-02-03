package sunkyung.yumwaysubway;

import java.util.Map;
import sunkyung.yumwaysubway.context.ApplicationContextListener;

public class GreetingListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("맛있는 서브웨이에 오신 것을 환영합니다");
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("안녕히 가세요!");
  }

}
