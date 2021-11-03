import React, { useEffect } from 'react'

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

export default function CardSection(props) {
	const valueName = `${props.action.toLowerCase()}Price`
	const binancePrices = props.data["Binance"].map(price => price[valueName]);
	const coinbasePrices = props.data["Coinbase"].map(price => price[valueName]);

	// useEffect(() => console.log("Data: ", binancePrices))

	return (
		<div>
			<h5 className="card-text section-title mb-1">{props.action}</h5>
			<div className="d-flex flex-column justify-content-between mb-2">
				<div className="row">
					<div className="col-4">
						<div className="price-label">Binance</div>
					</div>
					<div className="col-4 d-flex justify-content-center">
						<span className={`price-num ms-auto ${checkChange(binancePrices, valueName)}`}>
							{binancePrices[binancePrices.length - 1]}
						</span>
					</div>
					<div className="col-4 d-flex justify-content-end align-items-center">
						<div className="d-flex justify-content-center">
							<span class="badge bg-success">Buy</span>
						</div>
					</div>
				</div>
				<div className="row">
					<div className="col-4">
						<div className="price-label">Coinbase</div>
					</div>
					<div className="col-4 d-flex justify-content-center">
						<span className={`price-num ms-auto ${checkChange(coinbasePrices, valueName)}`}>
							{coinbasePrices[coinbasePrices.length - 1]}
						</span>
					</div>
					<div className="col-4 d-flex justify-content-end align-items-center">
						<div className="d-flex justify-content-center">
							<span class="badge bg-success">Buy</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	)
}
