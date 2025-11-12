import { Link } from 'react-router-dom';
import { useAuth } from '../../context/AuthContext';

const Navbar = () => {
  const { user, logout, isAuthenticated } = useAuth();

  const handleLogout = async () => {
    await logout();
  };

  return (
    <nav className="navbar">
      <div className="container">
        <div className="navbar-content">
          <Link to="/" className="navbar-brand">
            Event Management
          </Link>

          <div className="navbar-links">
            <Link to="/" className="navbar-link">
              All events
            </Link>

            {isAuthenticated && (
              <Link to="/my-events" className="navbar-link">
                My events
              </Link>
            )}

            {isAuthenticated ? (
              <div className="navbar-user">
                <span>
                  Hi, {user?.firstName}!
                  {user?.role === 'ADMIN' && (
                    <span className="admin-badge">ADMIN</span>
                  )}
                </span>
                <button
                  onClick={handleLogout}
                  className="btn btn-secondary"
                >
                  Logout
                </button>
              </div>
            ) : (
              <div className="navbar-user">
                <Link to="/login" className="btn btn-secondary">
                  Sign In
                </Link>
              </div>
            )}
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;