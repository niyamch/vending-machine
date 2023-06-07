package com.vending.machine.service;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.machine.domain.CoinType;
import com.vending.machine.domain.Product;
import com.vending.machine.dto.ChangeDto;
import com.vending.machine.repository.CoinRepository;
import com.vending.machine.repository.ProductRepository;
import com.vending.machine.util.Constants;

@Service
public class MachineService {
	@Autowired
	private CoinRepository coinRepository;

	@Autowired
	private ProductRepository productRepository;

	public String insertCoin(String coinName) {
		if (!EnumUtils.isValidEnum(CoinType.class, coinName)) {
			return Constants.INVALID_COIN;
		}

		coinRepository.addCoin(CoinType.valueOf(coinName));
		String formattedInsertedAmountInLeva = String.format("%.2f", coinRepository.getInsertedAmount() / 100d);

		return Constants.AVAILABLE_AMOUNT + Constants.SPACE + formattedInsertedAmountInLeva + Constants.LV
				+ Constants.DOT;
	}

	public ChangeDto returnChange() {
		return coinRepository.returnChangeAndGetDto();
	}

	public String buyProduct(String productName) {
		Product product = productRepository.getProductByName(productName);
		if (product == null) {
			return Constants.UNKNOWN_PRODUCT;
		}

		// TODO check if parite sa dostatychni

		String responseMessage = productRepository.buyProductAndGetMessage(product);
		if (responseMessage.equals(Constants.PRODUCT_OUT_OF_STOCK)) {
			return responseMessage;
		}

		int remainingAmountRequired = coinRepository.getRemainingAmountRequired(product.getPriceInStotinki());
		if (remainingAmountRequired > 0) {
			return Constants.SHORTAGE_OF + Constants.SPACE + String.format("%.2f", remainingAmountRequired / 100d)
					+ Constants.LV + Constants.DOT;
		}

		coinRepository.reduceInsertedAmount(product.getPriceInStotinki());
		String amountLeft = Constants.AVAILABLE_AMOUNT + Constants.SPACE
				+ String.format("%.2f", coinRepository.getInsertedAmount() / 100d) + Constants.LV + Constants.DOT;

		return responseMessage + Constants.SPACE +  amountLeft;
	}
}
