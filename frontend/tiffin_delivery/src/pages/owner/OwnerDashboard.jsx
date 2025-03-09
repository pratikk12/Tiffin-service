import { useState } from "react";
// import { useNavigate } from "react-router-dom";
import { addMessDetails } from "../../services/api";

const OwnerDashboard = () => {
  const [messName, setMessName] = useState("");
  const [description, setDescription] = useState("");
  const [contact, setContact] = useState("");
  const [address, setAddress] = useState("");
  const [city, setCity] = useState("");
  // const navigate = useNavigate();
  const handleMessDetails = async (e) => {
    e.preventDefault();
    try {
      await addMessDetails({
        address,
        city,
        contact,
        description,
        messName,
      });
      alert("Mess added Sucessfully");
    } catch (err) {
      console.log("failed", err);
      alert("Failed");
    }
  };

  return (
    <div className="main-container">
      <div className="container">
        <h1>This is owner Dashboard</h1>
        <p>your id is : </p>
        <form action="" onSubmit={handleMessDetails} className="mess-details">
          <input
            type="text"
            placeholder="Enter Mess Name"
            value={messName}
            onChange={(e) => setMessName(e.target.value)}
            required
          />
          <input
            type="text"
            placeholder="Enter Mess Description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
          <input
            type="tel"
            placeholder="Enter Phone Number"
            value={contact}
            onChange={(e) => setContact(e.target.value)}
            required
          />
          <input
            type="text"
            placeholder="Enter Mess Address"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            required
          />
          <input
            type="text"
            placeholder="Enter city"
            value={city}
            onChange={(e) => setCity(e.target.value)}
            required
          />
          <button type="submit" className="addmess-btn">
            Add Mess
          </button>
        </form>
      </div>
    </div>
  );
};
export default OwnerDashboard;
