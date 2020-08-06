package com.wellsfargo.fsd.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;

public class LoanDaoJdbcImpl implements LoanDao {

	public static final String INS_LN_QRY = "INSERT INTO loans(loanId,p,r,emis,dob,status) VALUES(?,?,?,?,?,?)";
	public static final String UPD_LN_QRY = "UPDATE loans SET p=?,r=?,emis=?,dob=?,status=? WHERE loanId=?";
	public static final String DEL_LN_QRY = "DELETE FROM loans WHERE loanId=?";
	public static final String GET_BY_ID_LN_QRY = "SELECT loanId,p,r,emis,dob,status FROM loans WHERE loanId=?";
	public static final String GET_ALL_LNS_QRY = "SELECT loanId,p,r,emis,dob,status FROM loans";

	public Loan add(Loan loan) throws LoanException {
		if (loan != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_LN_QRY);) {

				pst.setInt(1, loan.getLoanId());
				pst.setDouble(2, loan.getPrincipal());
				pst.setDouble(3, loan.getRateOfInterest());
				pst.setInt(4, loan.getEmiCount());
				pst.setDate(5, Date.valueOf(loan.getDateOfDisbursment()));
				pst.setString(6, loan.getStatus());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new LoanException("An error occured, Could not add the loan details!");
			}
		}
		return loan;
	}

	public Loan save(Loan loan) throws LoanException {
		if (loan != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_LN_QRY);) {

				pst.setDouble(1, loan.getPrincipal());
				pst.setDouble(2, loan.getRateOfInterest());
				pst.setInt(3, loan.getEmiCount());
				pst.setDate(4, Date.valueOf(loan.getDateOfDisbursment()));
				pst.setString(5, loan.getStatus());
				pst.setInt(6, loan.getLoanId());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new LoanException("An error occured, Could not save the loan details!");
			}
		}
		return loan;
	}

	public boolean deleteById(int loandId) throws LoanException {
		boolean isDeleted = false;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_LN_QRY);) {

			pst.setInt(1, loandId);

			int rowsCount = pst.executeUpdate();
			
			isDeleted= rowsCount>0 ;

		} catch (SQLException exp) {
			throw new LoanException("An error occured, Could not delete the loan details!");
		}

		return isDeleted;
	}

	public List<Loan> getAll() throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

	public Loan getById(int loanId) throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

}
