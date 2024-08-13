package com.ofss.main.ServiceRepository;

import com.ofss.main.Repository.ChequeRepo;
import com.ofss.main.Repository.ChequeRepoImpl;

public class ChequeServiceImpl implements ChequeService {

    ChequeRepo chequeService = new ChequeRepoImpl();

    public String Cheque(int PayeeChequeId, int PayerChequeId, int ChequeAmount) {
        return chequeService.Cheque(PayeeChequeId, PayerChequeId, ChequeAmount);
    }
}
