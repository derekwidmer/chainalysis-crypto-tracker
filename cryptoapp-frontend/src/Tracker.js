import React, { useEffect } from 'react'
import CryptoCard from './CryptoCard'
import { bitcoin, ethereum } from '../src/icons'
import axios from 'axios';

export default function Tracker(props) {

	const axiosInstance = axios.create({
		baseURL: "http://127.0.0.1:8080/api/price",
		headers: { 'Content-Type': 'application/json' }
	});

	useEffect(() => {
		axiosInstance.get().then(res => {
			console.log(res)
		}).catch(error => console.log(error))
	})

	return (
		<div className="tracker d-flex justify-content-center align-items-center">
			<div className="row">
				<CryptoCard ticker={"BTC"} icon={bitcoin} />
				<CryptoCard ticker={"ETH"} icon={ethereum} />
			</div>
		</div>
	)
}
