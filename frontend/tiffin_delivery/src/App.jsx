import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
  useLocation,
} from "react-router-dom";
import Home from "./pages/Home";
import AboutUs from "./pages/AboutUs";
import MessRegistration from "./pages/MessRegistration";
import MessLogin from "./pages/MessLogin";
import Contact from "./pages/ContactUs";
import Welcome from "./pages/Welcome";
import Header from "./pages/Header";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import OwnerDashboard from "./pages/owner/OwnerDashboard";
import UserDashboard from "./pages/UserDashboard";

function App() {
  return (
    <Router>
      <LayOut />
    </Router>
  );
}

function LayOut() {
  const location = useLocation();
  const hideHeaderRoutes = [
    "/",
    "/welcome",
    "/login",
    "/signup",
    "/messRegistration",
    "/messlogin",
    "/Welcome",
    "/owner-dashboard",
  ]; // Paths where header should be hidden

  return (
    <>
      {/* Show Header only if current path is NOT in hideHeaderRoutes */}
      {!hideHeaderRoutes.includes(location.pathname) && <Header />}

      <Routes>
        <Route path="/" element={<Navigate to="/welcome" />} />
        <Route path="/welcome" element={<Welcome />} />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<AboutUs />} />
        <Route path="/messRegistration" element={<MessRegistration />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/messlogin" element={<MessLogin />} />
        <Route path="/owner-dashboard" element={<OwnerDashboard />} />
        <Route path="/profile" element={<UserDashboard />} />
      </Routes>
    </>
  );
}

export default App;
