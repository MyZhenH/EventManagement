import { useState } from 'react';
import { useNavigate, Link, useLocation } from 'react-router-dom';
import { useAuth } from '../../context/AuthContext';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const { login } = useAuth();
  const navigate = useNavigate();
  const location = useLocation();

  const from = location.state?.from?.pathname || '/';

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    setLoading(true);

    const result = await login(email, password);

    if (result.success) {
      navigate(from, { replace: true });
    } else {
      setError(result.message || 'Inloggning misslyckades');
    }

    setLoading(false);
  };

  return (
    <div className="auth-container">
      <div className="auth-box">
        <div>
          <h2 className="auth-title">Logga in</h2>
          <p className="auth-subtitle">
            Eller{' '}
            <Link to="/register" className="auth-link">
              skapa ett nytt konto
            </Link>
          </p>
        </div>

        <form onSubmit={handleSubmit}>
          {error && (
            <div className="alert alert-error">
              {error}
            </div>
          )}

          <div className="form-group">
            <label htmlFor="email" className="form-label">
              Email
            </label>
            <input
              id="email"
              name="email"
              type="email"
              required
              className="form-input"
              placeholder="din.email@exempel.com"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>

          <div className="form-group">
            <label htmlFor="password" className="form-label">
              Lösenord
            </label>
            <input
              id="password"
              name="password"
              type="password"
              required
              className="form-input"
              placeholder="••••••••"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>

          <div className="form-group">
            <button
              type="submit"
              disabled={loading}
              className="btn btn-primary btn-full"
            >
              {loading ? 'Loggar in...' : 'Logga in'}
            </button>
          </div>

          <div className="text-center">
            <Link to="/" className="auth-link">
              ← Tillbaka till evenemang
            </Link>
          </div>
        </form>

        <div className="test-users">
          <p className="test-users-title">Testanvändare:</p>
          <p>Admin: admin@event.se / Admin123</p>
          <p>User: user@event.se / User123</p>
        </div>
      </div>
    </div>
  );
};

export default Login;