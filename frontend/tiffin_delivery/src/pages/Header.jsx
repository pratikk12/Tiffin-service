import { Link } from "react-router-dom";
import "../styles/Header.css";
import UserProfile from "./UserProfile";

function Header() {
  return (
    <>
      <Nav />
    </>
  );
}

const Nav = () => {
  return (
    <nav className="navbar">
      <ul>
        <li>
          <Link to="/home">Home</Link>
        </li>
        <li>
          <Link to="/about">AboutUs</Link>
        </li>
        <li>
          <Link to="/contact">Contact Us</Link>
        </li>
        {/* <li><Link to="/addmess">Add Mess</Link></li> */}
      </ul>
      <div className="relative">
        <UserProfile />
      </div>
    </nav>
  );
};

export default Header;
