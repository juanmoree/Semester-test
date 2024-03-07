import axios from "axios";

const REST_API_BASE_URL = "http://localhost:9000/grados";

export const listGrades = () => {
    return axios.get(REST_API_BASE_URL);
};