import { API_URL_BASE } from "../config";
import axios from 'axios';

export const apiHello = () => {
    return axios.get(API_URL_BASE + '/hello');
}