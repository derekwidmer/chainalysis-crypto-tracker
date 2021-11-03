import React, { useEffect } from 'react'
import CardSection from './CardSection';

export default function CryptoCard(props) {

	const priceData = props.data ? props.data[props.ticker] : {};

	useEffect(() => console.log("Price data for ", props.ticker, ":", priceData));

	return (
		<div className=" col-12 col-lg-6 p-3 d-flex justify-content-center align-items-center">
			<div className="card crypto-card" style={{ width: "25rem" }}>
				<div className="card-body upper-body">
					<h5 className="card-title crypto-title px-2 d-flex align-items-center">
						{props.ticker}
						<img className="icon ms-auto" alt="svgImg" src={props.icon} />
					</h5>
				</div>
				<div className="card-body">
					<div className="px-1 pb-1">
						<div className="d-flex flex-column">
							<CardSection action="Buy" data={priceData}/>
							<CardSection action="Sell" data={priceData}/>
							{/* <div className="d-flex justify-content-between mb-2">
								<div className="price-label">Coinbase</div>
								<span className={`price-num ms-auto ${checkChange(coinbasePrices, "buyPrice")}`}>
									{latestPriceCoinbase["buyPrice"]}
								</span>
							</div>
							<h5 className="card-text section-title">Sell</h5>
							<div className="d-flex justify-content-between mb-2">
								<div className="price-label">Binance</div>
								<span className={`price-num ms-auto ${checkChange(coinbasePrices, "buyPrice")}`}>
									{latestPriceCoinbase["buyPrice"]}
								</span>
							</div>
							<div className="d-flex justify-content-between mb-2">
								<div className="price-label">Coinbase</div>
								<span className={`price-num ms-auto ${checkChange(coinbasePrices, "sellPrice")}`}>
									{latestPriceCoinbase["sellPrice"]}
								</span>
							</div> */}
						</div>
					</div>
				</div>
			</div>
		</div >
	)
}
