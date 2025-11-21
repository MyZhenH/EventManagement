export const formatEventDate = (startDate, endDate) => {
  if (!startDate)
  return "Date not available";

  const start = new Date(startDate);
  const end = endDate ? new Date(endDate) : null;

  const dateOptions = { year: "numeric", month: "long", day: "numeric" };
  const timeOptions = { hour: "2-digit", minute: "2-digit" };

  if (!end) {
    return `${start.toLocaleDateString("sv-SE", dateOptions)} kl. ${start.toLocaleTimeString("sv-SE", timeOptions)}`;
  }

  const sameDay = start.toDateString() === end.toDateString();

  if (sameDay) {
    return `${start.toLocaleDateString("sv-SE", dateOptions)} kl. ${start.toLocaleTimeString("sv-SE", timeOptions)} - ${end.toLocaleTimeString("sv-SE", timeOptions)}`;
  } else {
    return `${start.toLocaleDateString("sv-SE", dateOptions)} kl. ${start.toLocaleTimeString("sv-SE", timeOptions)} - ${end.toLocaleDateString("sv-SE", dateOptions)} kl. ${end.toLocaleTimeString("sv-SE", timeOptions)}`;
  }
};
