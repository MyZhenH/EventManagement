import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import Navbar from './components/layout/Navbar';
import EventList from './components/events/EventList';
import EventDetails from './components/events/EventDetails';
import MyEvents from './components/events/MyEvents';
import Login from './components/auth/Login';
import Footer from "./components/footer/Footer";
import AboutPage from "./pages/AboutPage";
import ScrollToTop from "./components/layout/ScrollToTop";
import HomePage from "./pages/HomePage";
import AdminDashboard from "./components/admin/AdminDashboard";
import EventsPage from "./pages/EventsPage";

function App() {
  return (
    <Router>
    <ScrollToTop />
      <AuthProvider>
        <div className="min-h-screen bg-gray-50">
          <Navbar />
          <Routes>
            {/* Public routes */}
            <Route path="/" element={<HomePage />} />
            <Route path="/" element={<EventList />} />
            <Route path="/events/:eventId" element={<EventDetails />} />
            <Route path="/login" element={<Login />} />
            <Route path="/events" element={<EventsPage />} />

            {/* About page route */}
              <Route path="/about" element={<AboutPage />} />

            {/* Protected routes */}
            <Route path="/my-events" element={<MyEvents />} />
            {/* Admin routes */}
                        <Route path="/admin" element={<AdminDashboard />} />
          </Routes>

           <Footer />
        </div>
      </AuthProvider>
    </Router>
  );
}

export default App;