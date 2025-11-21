import { Link } from 'react-router-dom';
import { useAuth } from '../../context/AuthContext';
import { FiUser } from 'react-icons/fi';


const Navbar = () => {
  const { user, logout, isAuthenticated } = useAuth();

  const handleLogout = async () => {
    await logout();
  };

  const publicLinks = [
      { name: "All events", path: "/events" },
      { name: "About", path: "/about" },
      { name: "Contact", path: "/contact" },
      { name: "Help", path: "/help" },
    ];

  return (
    <nav className="navbar">
      <div className="container">
        <div className="navbar-content">
          <Link to="/" className="navbar-brand">
            Event Management
          </Link>

            <div className="navbar-links">
                {publicLinks.map((link) => (
                <Link key={link.name} to={link.path} className="navbar-link">
                {link.name}
                </Link>
                ))}


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
                <Link to="/login" className="btn btn-login">
                  <FiUser /> Sign In
                </Link>
              </div>
            )}
              {/* Admin Dashboard link  */}
                        <Link to="/admin" className="navbar-link ml-4">
                          Admin Dashboard
                        </Link>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;