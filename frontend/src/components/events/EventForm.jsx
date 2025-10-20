import React, { useState } from "react";

const categories = ["Conference", "Workshop", "Meetup", "Webinar"];
const statuses = ["Scheduled", "Cancelled", "Completed"];

export default function EventForm() {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [eventDate, setEventDate] = useState("");
    const [isOnline, setIsOnline] = useState(false);
    const [location, setLocation] = useState("");
    const [category, setCategory] = useState("");
    const [eventStatus, setEventStatus] = useState("");
    const [errors, setErrors] = useState({});


    function validate() {
        const newErrors = {};

        if (!title.trim()) newErrors.title = "Title is required";
        if (!description.trim()) newErrors.description = "Description is required";
        if (!eventDate) newErrors.eventDate = "Event date is required";
        if (!isOnline && !location.trim()) newErrors.location = "Location is required if not online";
        if (!category) newErrors.category = "Category is required";
        if (!eventStatus) newErrors.eventStatus = "Event status is required";

        return Object.keys(newErrors).length === 0;
    }

    function handleSubmit(e) {
        e.preventDefault();
        if (!validate()) return;

        const eventData = {
            title, description, eventDate,
            location: isOnline ? "Online" : location, category, eventStatus
        }

        console.log("Event saved:", eventData);
        alert("Event saved successfully!");
    }

    return (
        <form onSubmit={handleSubmit} style={{maxWidth: "400px", margin: "auto"}}>
            <div>
                <label htmlFor="title">Title: *</label><br/>
                <input
                    id="title"
                    type="text"
                    value={title}
                    onChange={e => setTitle(e.target.value)}
                    aria-describedby="title-error"
                    required
                />

                {errors.title && <div id="title-error" style={{color: "red"}}>{errors.title}</div>}
            </div>

            <div>
                <label htmlFor="description">Description: *</label><br/>
                <input
                    id="description"
                    type="text"
                    value={description}
                    onChange={e => setDescription(e.target.value)}
                    aria-describedby="description-error"
                    required
                />

                {errors.description && <div id="description-error" style={{color: "red"}}>{errors.description}</div>}
            </div>

            <div>
                <label htmlFor="eventDate">Event date: *</label><br/>
                <input
                    id="eventDate"
                    type="date"
                    value={eventDate}
                    onChange={e => setEventDate(e.target.value)}
                    aria-describedby="eventDate-error"
                    required
                />

                {errors.eventDate && <div id="eventDate-error" style={{color: "red"}}>{errors.eventDate}</div>}
            </div>

            <div>
                <label>
                    <input
                        type="checkbox"
                        checked={isOnline}
                        onChange={e => setIsOnline(e.target.checked)}
                    />

                    {" "}Online event
                </label>
            </div>

            {!isOnline && (
                <div>
                    <label htmlFor="location">Location: *</label><br/>
                    <input
                        id="location"
                        type="text"
                        value={location}
                        onChange={e => setLocation(e.target.value)}
                        aria-describedby="location-error"
                        required={!isOnline}
                    />

                    {errors.location && <div id="location-error" style={{color: "red"}}>{errors.location}</div>}
                </div>
            )}

            <div>
                <label htmlFor="category">Category: *</label><br/>
                <select
                    id="category"
                    value={category}
                    onChange={e => setCategory(e.target.value)}
                    aria-describedby="category-error"
                    required
                >
                    <option value="" disabled>Select category</option>

                    {categories.map(category => (
                        <option key={category} value={category}>{category}</option>
                    ))}
                </select>

                {errors.category && <div id="category-error" style={{color: "red"}}>{errors.category}</div>}
            </div>

            <div>
                <label htmlFor="eventStatus">Event status: *</label><br/>
                <select
                    id="eventStatus"
                    value={eventStatus}
                    onChange={e => setEventStatus(e.target.value)}
                    aria-describedby="eventStatus-error"
                    required
                >
                    <option value="" disabled>Select event status</option>

                    {eventStatus.map(eventStatus => (
                        <option key={eventStatus} value={eventStatus}>{eventStatus}</option>
                    ))}
                </select>

                {errors.eventStatus && <div id="eventStatus-error" style={{color: "red"}}>{errors.eventStatus}</div>}
            </div>

            <button type="submit" style={{marginTop: "10px"}}>Save event</button>
        </form>
    );
}
