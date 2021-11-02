import React from 'react'

export default function CryptoCard(props) {
	return (
		<div className=" col-12 col-md-6 p-3 d-flex justify-content-center align-items-center">
			<div className="card crypto-card">
				<div className="card-body upper-body">
					<h5 className="card-title crypto-title px-2 d-flex align-items-center">
						{props.ticker}
						<img className="icon ms-auto" alt="svgImg" src={props.icon} />
					</h5>
				</div>
				<div className="card-body">
					<h5 className="card-text px-1 pb-1">Price: </h5>
				</div>
			</div>
		</div >
	)
}
