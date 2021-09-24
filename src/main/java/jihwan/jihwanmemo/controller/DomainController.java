package jihwan.jihwanmemo.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import javassist.NotFoundException;
import jihwan.jihwanmemo.domain.Memo;
import jihwan.jihwanmemo.dto.Request;
import jihwan.jihwanmemo.service.MemoService;
import jihwan.jihwanmemo.simpleinfo.MemoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class DomainController {


    private MemoService memoService;


    @Autowired
    public DomainController(MemoService memoService){
        this.memoService = memoService;
    }

    @PostMapping("/memos")
    public Memo post(@RequestBody Request memoRequest, HttpServletResponse response) {


        Memo memo = new Memo(memoRequest.getTitle(), memoRequest.getText());
        try{
            Memo memo1 = memoService.post(memo);
            response.setStatus(201);
        }catch (Exception e)
        {
            response.setStatus(500);
        }
        return memo;
    }

    @PutMapping("/memos/{memoid}")
    public MemoSimple put(@PathVariable("memoid") Long id, @RequestBody Request updateRequest, HttpServletResponse response) {
        MemoSimple memoSimple = new MemoSimple();

        try{
            memoSimple = memoService.update(id, updateRequest);
            response.setStatus(200);
        }catch (Exception e){
            response.setStatus(500);
        }

        return memoSimple;

    }


    @DeleteMapping("/memos/{memoId}")
    public void delete(@PathVariable("memoId") Long id, HttpServletResponse response){

        try {
            memoService.delete(id);
            response.setStatus(200);
        }catch (NotFoundException e){
            response.setStatus(404);
        }catch(Exception e){
            response.setStatus(500);
        }

    }
    @GetMapping("/memos{memoId}")
    public Memo Detailget(@PathVariable Long id, HttpServletResponse response){

        Memo memo = new Memo();
        try{
            memo = memoService.getmemo(id);
            response.setStatus(200);
        }catch (NotFoundException e){
            response.setStatus(404);
        }catch (Exception e){
            response.setStatus(500);
        }

        return memo;
    }
    //페이지 API는 시간이 없어서 못만들었어요 ㅠㅠㅠㅠ... 그래도 저 정말 열심히 만들었어요 !!
}
