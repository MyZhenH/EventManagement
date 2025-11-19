import React, { useState, useEffect } from "react";
import { eventService } from "../../services/eventService";
import AdminEventCard from "./AdminEventCard";
import AdminEventForm from "./AdminEventForm";
import "./AdminDashboard.css";


const AdminDashboard = () => {
 const [events, setEvents] = useState([]);
 const [editingEvent, setEditingEvent] = useState(null);
 const [showForm, setShowForm] = useState(false);
 const [loadingForm, setLoadingForm] = useState(false);


 const fetchEvents = async () => {
   try {
     const data = await eventService.getAllEvents();
     setEvents(data);
   } catch (error) {
     console.error("Problem fetching events:", error);
   }
 };


 useEffect(() => {
   fetchEvents();
 }, []);


 const handleCreateNew = () => {
   setEditingEvent(null);
   setShowForm(true);
 };


 const handleEdit = async (event) => {
   setLoadingForm(true);
   try {
     const detailedEvent = await eventService.getEventById(event.eventId);
     setEditingEvent({ ...detailedEvent, eventId: event.eventId }); // ensure eventId
   } catch (err) {
     console.warn(
       "Failed to fetch detailed event, using basic info",
       err
     );
     setEditingEvent({ ...event, eventId: event.eventId });
   } finally {
     setShowForm(true);
     setLoadingForm(false);
   }
 };






 const handleSave = () => {
   fetchEvents();
   setEditingEvent(null);
   setShowForm(false);
 };


 const handleCancel = () => {
   setEditingEvent(null);
   setShowForm(false);
 };


 return (
   <div className="admin-dashboard">
     <h2>Admin Dashboard</h2>


     <button onClick={handleCreateNew} className="btn btn-primary mb-4">
       Create New Event
     </button>


     {showForm && !loadingForm && (
       <AdminEventForm
         eventToEdit={editingEvent}
         onSave={handleSave}
         onCancel={handleCancel}
       />
     )}


     <div className="admin-events-grid">
       {events.length > 0 ? (
         events.map((event) => (
           <AdminEventCard
             key={event.eventId}
             event={event}
             onUpdate={fetchEvents}
             onEdit={handleEdit}
           />
         ))
       ) : (
         <p>No events found.</p>
       )}
     </div>
   </div>
 );
};


export default AdminDashboard;

