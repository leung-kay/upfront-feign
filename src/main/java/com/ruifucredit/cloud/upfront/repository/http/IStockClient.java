package com.ruifucredit.cloud.upfront.repository.http;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.ruifucredit.cloud.inventory.support.controller.IStockController;
import com.ruifucredit.cloud.inventory.support.dto.Stock;
import com.ruifucredit.cloud.kit.dto.Outcoming;
import com.ruifucredit.cloud.upfront.repository.http.IStockClient.StockClientFallback;

@FeignClient(name = "inventory-feign", fallback = StockClientFallback.class)
public interface IStockClient extends IStockController {

	@Component
	class StockClientFallback implements IStockClient {

		private Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Override
		public Outcoming<Stock> queryStock(Long id) {
			logger.info("StockClientFallback.queryStock.id: {}", id);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

		@Override
		public Outcoming<List<Stock>> queryCommodityStock(Long id) {
			logger.info("StockClientFallback.queryCommodityStock.id: {}", id);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

		@Override
		public Outcoming<Stock> queryCommodityStock(Long id, Long subId) {
			logger.info("StockClientFallback.queryCommodityStock.id: {}, subId: {}", id, subId);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

		@Override
		public Outcoming<Stock> modifyStock(Long id, Stock stock) {
			logger.info("StockClientFallback.modifyStock.id: {}, stock: {}", id, stock);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

		@Override
		public Outcoming<List<Stock>> createStock(List<Stock> stock) {
			logger.info("StockClientFallback.createStock.stock: {}", stock);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

		@Override
		public Outcoming<Stock> removeStock(Long id) {
			logger.info("StockClientFallback.removeStock.id: {}", id);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

	}

}
