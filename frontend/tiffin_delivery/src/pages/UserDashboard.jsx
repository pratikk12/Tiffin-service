import { useEffect, useState } from "react";

const UserDashboard = () => {
  const [user, setUser] = useState(null);
  const email = localStorage.getItem("email"); // Retrieve email

  useEffect(() => {
    if (email) {
      fetch(`http://localhost:8080/api/users/email?email=${email}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error("User Not Found");
          }
          return response.json();
        })
        .then((data) => {
          console.log("Fetched User Data:", data); // ✅ Log user data
          setUser(data);
        })
        .catch((error) => {
          console.error("Error Fetching User Data:", error);
        });
    }
  }, [email]);

  return (
    <div>
      <h1>User Profile</h1>
      {user ? (
        <>
          <p>
            <strong>Name:</strong> {user.name}
          </p>
          <p>
            <strong>Email:</strong> {email}
          </p>
        </>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default UserDashboard;
