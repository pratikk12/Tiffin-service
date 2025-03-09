import { useState } from "react";
import "../styles/mess_registration.css";
import { useNavigate } from "react-router-dom";
import { registerMessOwner } from "../services/api";

const MessRegistration = () => {
  const [name, setName] = useState("");
  const [userName, setUserName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [address, setAddress] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleMessRegistration = async (e) => {
    e.preventDefault();
    try {
      await registerMessOwner({
        name,
        userName,
        email,
        phoneNumber,
        address,
        password,
      });
      alert("Signup successfull redirecting to login");
      navigate("/messlogin");
    } catch (error) {
      console.log("Signup Failed", error);
      alert("sign up failed try again");
    }
  };

  return (
    <div className="main-container">
      <div className="container">
        <h2>Owner Registration</h2>
        <form action="" onSubmit={handleMessRegistration} className="register">
          <input
            type="text"
            placeholder="Enter Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
          <input
            type="text"
            placeholder="Enter username"
            value={userName}
            onChange={(e) => setUserName(e.target.value)}
            required
          />
          <input
            type="email"
            placeholder="Enter Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <input
            type="tel"
            placeholder="Enter Phone Number"
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
            required
          />
          <input
            type="text"
            placeholder="Enter address"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Enter password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit" className="register-btn">
            Register
          </button>
        </form>

        <p>Already have an account?</p>
        <button className="mess-login-btn" onClick={() => navigate("/messlogin")}>
          Login
        </button>
      </div>
    </div>
  );
};

export default MessRegistration;
