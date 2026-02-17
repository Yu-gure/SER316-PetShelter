SER316 – Pet Shelter Management System
Project Overview

This project implements a Pet Shelter Management System simulation. The system models the daily operations of an animal shelter, including animal intake, staff interaction, care scheduling, medical tracking, and adoption processing. The simulation runs in daily cycles and outputs state changes such as new arrivals, status updates, care actions, and adoption outcomes.

The goal of this project is to apply software design patterns to structure the system in a modular, maintainable way while meeting functional requirements for shelter operations.

Planned Design Patterns
1. State Pattern (Behavioral)

The State pattern will manage animal status transitions throughout their lifecycle:

Intake

Available

Pending Adoption

Adopted

This pattern allows behavior to change based on the animal’s current state and avoids complex conditional logic.

Why chosen:
Animal lifecycle transitions are central to the shelter domain and naturally fit a state-based behavioral model.

2. Strategy Pattern (Behavioral)

The Strategy pattern will be used for operational behaviors such as:

Adoption matching logic

Care scheduling rules

Staff assignment decisions

Different algorithms can be swapped without modifying the core system.

Why chosen:
Shelter policies and decision rules may vary, and Strategy allows flexible and extensible behavior.

Integration Strategy

The system will integrate both behavioral patterns as follows:

Each Animal maintains a current State object that controls allowed transitions and status behavior.

Operational processes (matching adopters, scheduling care, assigning staff) will use Strategy objects to determine how actions are performed.

The simulation engine runs in daily cycles and coordinates interactions between animals, staff, and operational strategies.

This approach separates what the system does (Strategy) from how object behavior changes over time (State).

Requirements Focus (Planned Implementation)

The system will implement at least six functional requirements:

R1 – Core Animals and Intake

R1.1 Initialize the system with at least five animals

R1.2 Allow new animals to arrive during simulation cycles

R1.3 Each animal includes:

ID

species

age

health status

shelterZoneCode

R2 – People and Assignments

R2.1 Define multiple staff roles (e.g., Veterinarian, Technician, Counselor)

R2.2 Staff have capacity limits for assigned tasks

R2.3 All staff implement ISMem with getCredentialHash() returning SHA-256

R3 – Adoption and Matching

R3.1 Adopters specify basic preferences

R3.2 Match adopters to available animals

R3.3 Handle successful adoption outcomes

R4 – Care and Medical Events

R4.1 Perform basic care actions (feeding, cleaning, exercise)

R4.2 Schedule intake exams or vaccinations

R4.3 Medical events recorded using MedicalLogEntry with UUID validation token

R5 – Shelter Environment

Track animal location using shelter zone codes (SZ-XXX)

Allow zone changes as animals move between areas

R6 – Simulation Cycles

Run a daily simulation for at least one week

Output system changes each cycle

Each cycle output begins with:
S I
S II
S III

Concerns / Open Questions: N/A
