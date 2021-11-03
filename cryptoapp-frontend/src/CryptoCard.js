import React, { useEffect } from 'react'
import CardSection from './CardSection';

export default function CryptoCard(props) {

	const priceData = props.data ? props.data[props.ticker] : {};

	useEffect(() => console.log("Price data for ", props.ticker, ":", priceData));

	return (
		<div className="col-12 p-3 d-flex justify-content-center align-items-center">
			<div className="card crypto-card">
				<div className="card-body upper-body">
					<h5 className="card-title crypto-title px-2 d-flex align-items-center">
						{props.ticker}
						<img className="icon ms-auto" alt="svgImg" src={props.icon} />
					</h5>
				</div>
				<div className="card-body">
					<div className="px-1">
						<div className="d-flex flex-column">
							<CardSection action="Buy" data={priceData} />
							<CardSection action="Sell" data={priceData} />
						</div>
					</div>
				</div>
			</div>
		</div >
	)
}
