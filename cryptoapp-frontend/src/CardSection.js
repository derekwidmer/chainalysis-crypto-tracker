import React from 'react'

export default function CardSection(props) {
	const valueName = `${props.action.toLowerCase()}Price`
	const binancePrices = props.data["Binance"].map(price => price[valueName]);
	const coinbasePrices = props.data["Coinbase"].map(price => price[valueName]);
	const latestBinance = binancePrices[binancePrices.length - 1];
	const latestCoinbase = coinbasePrices[coinbasePrices.length - 1];

	const checkChange = (prices, priceType) => {
		const length = prices.length;
		if (length >= 2) {
			if (prices[length - 1] > prices[length - 2]) {
				console.log("comparing ", prices[length - 1], " > ", prices[length - 2])
				return "increase";
			} else if (prices[length - 1] < prices[length - 2]) {
				console.log("comparing ", prices[length - 1], " < ", prices[length - 2])
				return "decrease";
			} else {
				return "stagnant";
			}
		}
	}

	const renderBadgeCheck = (myPrice, otherPrice) => {
		if (props.action == "Buy") {
			if (myPrice > otherPrice) {
				return false;
			} else return true;
		} else if (props.action == "Sell") {
			if (myPrice < otherPrice) {
				return false;
			} else return true;
		}
	}

	return (
		<div>
			<div className="d-flex align-items-center justify-content-between">
				<h5 className="card-text section-title mb-1">{props.action}</h5>
				<h6 className="card-text suggestion">Suggestion</h6>
			</div>
			<div className="d-flex flex-column justify-content-between mb-2">
				<div className="row">
					<div className="col-4">
						<div className="price-label">Binance</div>
					</div>
					<div className="col-4 d-flex justify-content-center">
						<span className={`price-num ms-auto ${checkChange(binancePrices, valueName)}`}>
							{latestBinance}
						</span>
					</div>
					<div className="col-4 d-flex justify-content-end align-items-center">
						<div className="d-flex justify-content-center">
							{renderBadgeCheck(latestBinance, latestCoinbase) ?
								<span class="badge bg-success">{props.action}</span> :
								<></>}
						</div>
					</div>
				</div>
				<div className="row">
					<div className="col-4">
						<div className="price-label">Coinbase</div>
					</div>
					<div className="col-4 d-flex justify-content-center">
						<span className={`price-num ms-auto ${checkChange(coinbasePrices, valueName)}`}>
							{latestCoinbase}
						</span>
					</div>
					<div className="col-4 d-flex justify-content-end align-items-center">
						<div className="d-flex justify-content-center">
							{renderBadgeCheck(latestCoinbase, latestBinance) ?
								<span class="badge bg-success">{props.action}</span> :
								<></>}
						</div>
					</div>
				</div>
			</div>
		</div>
	)
}
