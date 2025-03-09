import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { loginUser } from "../services/api";

import "../styles/login.css";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await loginUser({ email, password });

      console.log("Login Response Data:", response.data);

      if (response.status === 200) {
        const { token, user } = response.data;

        console.log("Token:", token);
        console.log("User:", user);

        if (!token || !user) {
          throw new Error("Invalid response structure from server");
        }

        // Store user details
        localStorage.setItem("token", token); // Store token for authentication
        localStorage.setItem("user", JSON.stringify(user)); // Store user object
        localStorage.setItem("email", user.email); // Store email separately

        console.log("User Logged In:", user);
        navigate("/home"); // Redirect after login
      } else {
        setError("Invalid email or password");
      }
    } catch (err) {
      setError("Login failed. Please try again. " + err);
    }
  };

  return (
    <div className="main-container">
      <div className="login-container">
        <h2>Login</h2>
        <form onSubmit={handleLogin}>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <button type="submit" className="login-btn">
            Login
          </button>
        </form>
        {error && <p className="error">{error}</p>}

        <p>{`Don't have an account?`}</p>
        <button className="register-btn" onClick={() => navigate("/signup")}>
          Register
        </button>
      </div>
    </div>
  );
};

export default Login;
