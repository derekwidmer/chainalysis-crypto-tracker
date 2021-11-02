import React from 'react'
import CryptoCard from './CryptoCard'
import { bitcoin, ethereum } from '../src/icons'

export default function Tracker(props) {
	return (
		<div className="tracker d-flex justify-content-center align-items-center">
			<div className="row">
				<CryptoCard ticker={"BTC"} icon={bitcoin} />
				<CryptoCard ticker={"ETH"} icon={ethereum} />
			</div>
		</div>
	)
}
