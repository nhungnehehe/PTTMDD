package com.phamtuyetnhung.connectors;

import com.phamtuyetnhung.models.Account;
import com.phamtuyetnhung.models.ListAccount;


import java.util.ArrayList;

public class AccountConnector {
    ListAccount listAccount;
    public AccountConnector()
    {
        listAccount = new ListAccount();
        listAccount.generate_sample_account_dataset();
    }
    public ArrayList<Account> get_all_accounts()
    {
        if ( listAccount==null)
        {
            listAccount = new ListAccount();
            listAccount.generate_sample_account_dataset();
        }
        return   listAccount.getAccounts();
    }
    public Account login(String usr, String pwd)
    {
        ListAccount la = new ListAccount();
        la.generate_sample_account_dataset();
        for (Account acc : la.getAccounts())
        {
            if (acc.getUsername().equalsIgnoreCase(usr) && acc.getPassword().equals(pwd))
            {
                return acc;
            }
        }
        return null;
    }
}
