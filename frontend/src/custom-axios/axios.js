import axios from 'axios';

const instance = axios.create({
    baseURL: "http://localhost:9091/api/library",
    headers: {
        'Access-Control-Allow-Origin': '*'
    },
    withCredentials: true
})

export default instance;