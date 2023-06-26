package sg.edu.nus.iss.paf24_jul2023.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf24_jul2023.exception.BankAccountNotFoundException;
import sg.edu.nus.iss.paf24_jul2023.model.BankAccount;

@Repository
public class BankAccountRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String GET_ACCOUNT_SQL = "select * from bank_account where id = ?";
    private final String WITHDRAW_SQL = "update bank_account set balance = balance - ? where id = ?";
    private final String DEPOSIT_SQL = "update bank_account set balance = balance + ? where id = ?";
    private final String CREATE_ACCOUNT_SQL = "insert into bank_account (full_name, is_blocked, is_active, account_type, balance) values (?, ?, ?, ?, ?)";
    // private final String CREATE_ACCOUNT2_SQL = "insert into bank_account values
    // (?, ?, ?, ?, ?, ?)";

    public BankAccount getAccountById(Integer bankAccountId) {
        // BankAccount bankAccount = jdbcTemplate.queryForObject(GET_ACCOUNT_SQL,
        //         BeanPropertyRowMapper.newInstance(BankAccount.class), bankAccountId);

        // if (bankAccount == null) {
        //     throw new BankAccountNotFoundException("Account not created");
        // }

        List<BankAccount> bankAccounts = jdbcTemplate.query(GET_ACCOUNT_SQL, BeanPropertyRowMapper.newInstance(BankAccount.class), bankAccountId);

        if (bankAccounts.isEmpty()) {
             throw new BankAccountNotFoundException("Account doesn't not exist.");
        }

        BankAccount bankAccount = bankAccounts.get(0);

        return bankAccount;
    }

    public Boolean withdrawAmount(Integer withdrawAccountId, Float withdrawAmount) {
        // "update bank_account set balance = balance - ? where id = ?"
        Integer iResult = jdbcTemplate.update(WITHDRAW_SQL, withdrawAmount, withdrawAccountId);

        return iResult > 0 ? true : false;
    }

    public Boolean depositAmount(Integer depositAccountId, Float depositAmount) {
        Integer iResult = jdbcTemplate.update(DEPOSIT_SQL, depositAmount, depositAccountId);

        return iResult > 0 ? true : false;
    }

    public Boolean createAccount(BankAccount bankAccount) {
        //"insert into bank_account (full_name, is_blocked, is_active, account_type, balance) values (?, ?, ?, ?, ?)";
        Integer iResult = jdbcTemplate.update(CREATE_ACCOUNT_SQL, bankAccount.getFullName(), bankAccount.getIsBlocked(), bankAccount.getIsActive(), bankAccount.getAccountType(), bankAccount.getBalance());

        return iResult > 0 ? true : false;
    }

}
