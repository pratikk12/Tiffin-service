import { useState } from "react";
import { GiHamburgerMenu } from "react-icons/gi";
import { IoClose } from "react-icons/io5";
import "../styles/user_profile.css"; // Import your CSS file
import { useNavigate } from "react-router-dom";

const UserProfile = () => {
  const navigate = useNavigate();
  const [isOpen, setIsOpen] = useState(false);
  const handleProfile = () => {
    navigate("/profile");
  };
  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    alert("user Logged out");
    navigate("/login");
  };

  return (
    <>
      {/* Hamburger Icon */}
      <GiHamburgerMenu
        onClick={() => setIsOpen(true)}
        size={30}
        className="hamburger-icon"
      />

      {/* Overlay Background */}
      {isOpen && (
        <div className="overlay" onClick={() => setIsOpen(false)}></div>
      )}

      {/* Sidebar Menu */}
      <div className={`sidebar ${isOpen ? "show-sidebar" : ""}`}>
        {/* Close Button */}
        <IoClose
          onClick={() => setIsOpen(false)}
          size={30}
          className="close-icon"
        />

        {/* Sidebar Content */}
        <div className="menu">
          <ul>
            <li onClick={handleProfile}>Profile</li>
            <li onClick={handleLogout}>Logout</li>
            <li>Settings</li>
          </ul>
        </div>
      </div>
    </>
  );
};

export default UserProfile;
