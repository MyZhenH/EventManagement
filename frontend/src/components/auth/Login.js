import { useEffect } from 'react';
import { Link } from 'react-router-dom';

const Login = () => {
  const handleAuth0Login = () => {
    // Redirect to Auth0 login via backend
    window.location.href = 'http://localhost:8080/oauth2/authorization/auth0';
  };

  useEffect(() => {
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get('error')) {
      alert('Login failed. Please try again.');
    }
  }, []);

  return (
    <div className="auth-container">
      <div className="auth-box">
        <div>
          <h2 className="auth-title">Welcome to Event Management</h2>
          <p className="auth-subtitle">
            Sign in to register for events and manage your bookings
          </p>
        </div>

        <div className="form-group">
          <button
            onClick={handleAuth0Login}
            className="btn btn-primary btn-full"
            style={{
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              gap: '0.75rem',
              fontSize: '1.1rem',
              padding: '1rem 1.5rem',
              fontWeight: '600'
            }}
          >
            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M12 2L2 7V13C2 19.5 6 22.5 12 24C18 22.5 22 19.5 22 13V7L12 2Z"
                    stroke="currentColor"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"/>
              <path d="M9 12L11 14L15 10"
                    stroke="currentColor"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"/>
            </svg>
            Sign in with Auth0
          </button>
        </div>

        <div className="text-center" style={{ marginTop: '1.5rem' }}>
          <Link to="/" className="auth-link">
            ← Browse events without logging in
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Login;