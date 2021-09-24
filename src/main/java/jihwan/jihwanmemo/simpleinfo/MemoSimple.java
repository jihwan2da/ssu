package jihwan.jihwanmemo.simpleinfo;

import jihwan.jihwanmemo.domain.Memo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemoSimple {

    public Long id;
    public String title;
    public LocalDateTime createdAt;
    public LocalDateTime updateAt;

    public MemoSimple(){}

    public MemoSimple(Memo memo){
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.createdAt = memo.getCreated();
        this.updateAt = memo.getUpdated();
    }

}
