package com.vending.machine.repository;

import org.springframework.stereotype.Repository;

import com.vending.machine.domain.Coin;
import com.vending.machine.domain.CoinType;
import com.vending.machine.dto.ChangeDto;
import com.vending.machine.util.Constants;

@Repository
public class CoinRepository {
	private Coin tenStotinki;
	private Coin twentyStotinki;
	private Coin fiftyStotinki;
	private Coin oneLev;
	private Coin twoLev;
	private int insertedAmountInStotinki;

	public CoinRepository() {
		setInitialData();
	}

	public void setInitialData() {
		tenStotinki = new Coin(CoinType.TEN_ST, 14);
		twentyStotinki = new Coin(CoinType.TWENTY_ST, 3);
		fiftyStotinki = new Coin(CoinType.FIFTY_ST, 7);
		oneLev = new Coin(CoinType.ONE_LEV, 5);
		twoLev = new Coin(CoinType.TWO_LEV, 10);
		insertedAmountInStotinki = 0;
	}

	public void addCoin(CoinType coinType) {
		switch (coinType) {
		case TEN_ST:
			tenStotinki.setQuantity(tenStotinki.getQuantity() + 1);
			System.out.print(tenStotinki.getType().value);
			insertedAmountInStotinki += tenStotinki.getType().value;
			break;
		case TWENTY_ST:
			twentyStotinki.setQuantity(twentyStotinki.getQuantity() + 1);
			System.out.print(twentyStotinki.getType().value);
			insertedAmountInStotinki += twentyStotinki.getType().value;
			break;
		case FIFTY_ST:
			fiftyStotinki.setQuantity(fiftyStotinki.getQuantity() + 1);
			System.out.print(fiftyStotinki.getType().value);
			insertedAmountInStotinki += fiftyStotinki.getType().value;
			break;
		case ONE_LEV:
			oneLev.setQuantity(oneLev.getQuantity() + 1);
			System.out.print(oneLev.getType().value);
			insertedAmountInStotinki += oneLev.getType().value;
			break;
		case TWO_LEV:
			twoLev.setQuantity(twoLev.getQuantity() + 1);
			System.out.print(twoLev.getType().value);
			insertedAmountInStotinki += twoLev.getType().value;
			break;
		}
	}

	public ChangeDto returnChangeAndGetDto() {
		int changeRemaining = this.insertedAmountInStotinki;
		ChangeDto changeDto = new ChangeDto(changeRemaining);

		return returnChangeAndGetDto(changeRemaining, changeDto);
	}

	public ChangeDto returnChangeAndGetDto(Integer changeRemaining, ChangeDto changeDto) {
		if (changeRemaining >= twoLev.getType().value && twoLev.getQuantity() > 0) {
			twoLev.setQuantity(twoLev.getQuantity() - 1);
			changeDto.setTwoLevQuantity(changeDto.getTwoLevQuantity() + 1);
			return returnChangeAndGetDto(changeRemaining - twoLev.getType().value, changeDto);
		}

		if (changeRemaining >= oneLev.getType().value && oneLev.getQuantity() > 0) {
			oneLev.setQuantity(oneLev.getQuantity() - 1);
			changeDto.setOneLevQuantity(changeDto.getOneLevQuantity() + 1);
			return returnChangeAndGetDto(changeRemaining - oneLev.getType().value, changeDto);
		}

		if (changeRemaining >= fiftyStotinki.getType().value && fiftyStotinki.getQuantity() > 0) {
			fiftyStotinki.setQuantity(fiftyStotinki.getQuantity() - 1);
			changeDto.setFiftyStoninkiQuantity(changeDto.getFiftyStoninkiQuantity() + 1);
			return returnChangeAndGetDto(changeRemaining - fiftyStotinki.getType().value, changeDto);
		}

		if (changeRemaining >= twentyStotinki.getType().value && twentyStotinki.getQuantity() > 0) {
			twentyStotinki.setQuantity(twentyStotinki.getQuantity() - 1);
			changeDto.setTwentyStoninkiQuantity(changeDto.getTwentyStoninkiQuantity() + 1);
			return returnChangeAndGetDto(changeRemaining - twentyStotinki.getType().value, changeDto);
		}

		if (changeRemaining >= tenStotinki.getType().value && tenStotinki.getQuantity() > 0) {
			tenStotinki.setQuantity(tenStotinki.getQuantity() - 1);
			changeDto.setTenStoninkiQuantity(changeDto.getTenStoninkiQuantity() + 1);
			return returnChangeAndGetDto(changeRemaining - tenStotinki.getType().value, changeDto);
		}

		insertedAmountInStotinki = changeRemaining;

		if (changeRemaining > changeDto.getTotalInStotinki()) {
			changeDto.setMessage(Constants.CAN_NOT_RETURN_CHANGE);
		} else {
			changeDto.setMessage(Constants.ALL_CHANGE_IS_RETURNED);
		}

		return changeDto;
	}

	public void reduceInsertedAmount(int reduceByAmount) {
		this.insertedAmountInStotinki = this.insertedAmountInStotinki - reduceByAmount;
	}

	public int getInsertedAmount() {
		return this.insertedAmountInStotinki;
	}

	public int getRemainingAmountRequired(int neededAmount) {
		return this.insertedAmountInStotinki > neededAmount ? 0 : neededAmount - this.insertedAmountInStotinki;
	}
}
