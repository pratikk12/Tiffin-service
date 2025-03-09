import { Link } from "react-router-dom";
import "../styles/welcome.css";

const Welcome = () => {
  return (
    <>
      <WelNav />
      <h1>Welcome to Tiffin</h1>
      <p>
        This project is a food delivery app designed to make it easy for people
        to get daily meals from local mess services. Many students, working
        professionals, and others need affordable, home-style meals but don’t
        have the time to cook or search for options every day. Our app connects
        users with nearby messes, where they can choose meals, subscribe to
        daily or monthly plans, and track deliveries in real-time.
      </p>
    </>
  );
};

const WelNav = () => {
  return (
    <div className="navbar">
      <ul>
        <li>
          <Link to="/login">Log in</Link>
        </li>
        <li>
          <Link to="/signup">Sign up</Link>
        </li>
        <li>
          <Link to="/messRegistration">Register Mess</Link>
        </li>
      </ul>
    </div>
  );
};

export default Welcome;
