import React, { useState } from 'react'
import CryptoCard from './CryptoCard'
import { bitcoin, ethereum } from '../src/icons'
import axios from 'axios';
import useInterval from './hooks';
import { sampleData } from './sampleData';

export default function Tracker(props) {

	// const axiosInstance = axios.create({
	// 	baseURL: "http://127.0.0.1:8080/api/price",
	// 	headers: { 'Content-Type': 'application/json' }
	// });

	// const [data, setData] = useState(sampleData);

	// useInterval(() => {
	// 	axiosInstance.get().then(res => {
	// 		setData(res.data);
	// 		console.log(res.data);
	// 	}).catch(error => console.log(error))
	// }, 5000)

	// setData(sampleData);

	return (
		<div className="tracker d-flex justify-content-center align-items-center">
			<div className="row">
				<CryptoCard ticker={"BTC"} icon={bitcoin} data={sampleData} />
				<CryptoCard ticker={"ETH"} icon={ethereum} data={sampleData} />
			</div>
		</div>
	)
}
