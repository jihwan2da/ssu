package jihwan.jihwanmemo.service;


import jihwan.jihwanmemo.domain.Memo;
import jihwan.jihwanmemo.dto.Request;
import jihwan.jihwanmemo.repository.MemoRepository;
import jihwan.jihwanmemo.simpleinfo.MemoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemoService {

    private MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    public Memo getmemo(Long id) throws Exception{

        Optional<Memo> memo = memoRepository.findById(id);
        Memo memo1 = memo.orElse(null);

        return memo1;
    }


    public Memo post (Memo memo) throws Exception{

        return memoRepository.save(memo);
    }

    @Transactional
    public MemoSimple update(Long id, Request updateRequest) throws  Exception{

        Optional<Memo> memo = memoRepository.findById(id);
        Memo memo1 = memo.orElse(null);


        memo1.setTitle(updateRequest.getTitle());
        memo1.setText((updateRequest.getText()));

        MemoSimple memoSimple = new MemoSimple(memo1);

        return memoSimple;
    }

    public void delete(Long id) throws Exception{
        memoRepository.deleteById(id);
    }





}
