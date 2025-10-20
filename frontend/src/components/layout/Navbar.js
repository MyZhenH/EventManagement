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
              Alla evenemang
            </Link>

            {isAuthenticated && (
              <Link to="/my-events" className="navbar-link">
                Mina evenemang
              </Link>
            )}

            {isAuthenticated ? (
              <div className="navbar-user">
                <span>
                  Hej, {user?.firstName}!
                  {user?.role === 'ADMIN' && (
                    <span className="admin-badge">ADMIN</span>
                  )}
                </span>
                <button
                  onClick={handleLogout}
                  className="btn btn-secondary"
                >
                  Logga ut
                </button>
              </div>
            ) : (
              <div className="navbar-user">
                <Link to="/login" className="navbar-link">
                  Logga in
                </Link>
                <Link to="/register" className="btn btn-secondary">
                  Registrera
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