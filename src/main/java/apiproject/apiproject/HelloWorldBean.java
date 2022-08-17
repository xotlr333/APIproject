package apiproject.apiproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //lombok
@AllArgsConstructor //생성자를 생성하는 어노테이션
@NoArgsConstructor //매개변수가 없는 생성자를 생성
public class HelloWorldBean {
    private String message;


}
