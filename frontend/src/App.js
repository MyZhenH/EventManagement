import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import Navbar from './components/layout/Navbar';
import EventList from './components/events/EventList';
import EventDetails from './components/events/EventDetails';
import MyEvents from './components/events/MyEvents';
import Login from './components/auth/Login';
import Register from './components/auth/Register';
import Footer from "./components/footer/Footer"; //Footer Test

function App() {
  return (
    <Router>
      <AuthProvider>
        <div className="min-h-screen bg-gray-50">
          <Navbar />
          <Routes>
            {/* Public routes - Everyone can see */}
            <Route path="/" element={<EventList />} />
            <Route path="/events/:eventId" element={<EventDetails />} />

            {/* Auth routes */}
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />

            {/* Protected routes - Required login */}
            <Route path="/my-events" element={<MyEvents />} />
          </Routes>

           <Footer />
        </div>
      </AuthProvider>
    </Router>
  );
}

export default App;