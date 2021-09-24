package jihwan.jihwanmemo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Request {
    private String title;
    private String text;
}
