import React, { useState } from 'react'
import CryptoCard from './CryptoCard'
import { bitcoin, ethereum } from '../src/icons'
import axios from 'axios';
import useInterval from './hooks';
import { sampleData } from './sampleData';

export default function Tracker(props) {

	const axiosInstance = axios.create({
		baseURL: "http://127.0.0.1:8080/api/price",
		headers: { 'Content-Type': 'application/json' }
	});

	const [data, setData] = useState(sampleData);
	const [isError, setError] = useState(false);

	useInterval(() => {
		axiosInstance.get().then(res => {
			setData(res.data);
			setError(false)
		}).catch(error => {
			setError(true)
		})
	}, 5000)

	return (
		<div className="tracker">
			<div className="container">
				<div className="d-flex flex-column justify-content-center align-items-center vh-100">
					<h1 className="text-center mb-4">Cryptocurrency Tracker</h1>
					<div className="row">
						<CryptoCard ticker={"BTC"} icon={bitcoin} data={data} />
						<CryptoCard ticker={"ETH"} icon={ethereum} data={data} />
					</div>
					{isError && <p className="mt-3">Cannot connect to the server right now. Showing sample data.</p>}
				</div>
			</div>
		</div>
	)
}
