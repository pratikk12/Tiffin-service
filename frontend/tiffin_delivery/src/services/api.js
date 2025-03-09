import axios from "axios";

const API_URL = "http://localhost:8080/api/auth";
const API_URL1 = "http://localhost:8080/api";

export const registerUser = async (users) => {
    return await axios.post(`${API_URL}/register`, users);
};
export const loginUser = async (users) => {
    return await axios.post(`${API_URL}/login`, users);
};

export const registerMessOwner = async (messowners) => {
    return await axios.post(`${API_URL}/messowner`, messowners);
};
export const loginMessOwner = async (messowners) => {
    return await axios.post(`${API_URL}/messlogin`, messowners);
};

export const addMessDetails = async (messdetails) => {
    return await axios.post(`${API_URL1}/mess`, messdetails);
};
