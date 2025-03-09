import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { loginMessOwner } from "../services/api";


const MessLogin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await loginMessOwner({ email, password });

      if (response.status === 200) {
        const { token, messowner } = response.data;
        localStorage.setItem("token", token);
        localStorage.setItem("user", JSON.stringify(messowner));
        navigate("/owner-dashboard");
      } else {
        setError("Invalid email or password");
      }
    } catch (err) {
      setError("Login failed. Please try again " + err);
    }
  };
  return (
    <div className="main-container">
      <div className="login-container">
        <h2>Owner Login</h2>
        <form onSubmit={handleLogin}>
          <input
            type="email"
            placeholder="Enter email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Enter password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <button type="submit" className="mess-login-btn">
            Login
          </button>
        </form>
        {error && <p className="error">{error}</p>}
        <p>{`Don't have an account?`}</p>
        <button className="register-btn" onClick={()=>navigate("/messRegistration")}>Owner Registration</button>
      </div>
    </div>
  );
};


export default MessLogin;