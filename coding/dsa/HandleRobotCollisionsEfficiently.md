# Stack + Sorting Simulation | Handle Robot Collisions Efficiently
Intuition

Robots move on a line and only collide when:

A robot moving Right (R)
meets
A robot moving Left (L)

Since robots start at different positions and move at the same speed, the only meaningful collisions happen between R robots on the left and L robots on the right.

Example pattern that causes collision:

R .... L

But these never collide:

L .... R
R .... R
L .... L

So the idea is to process robots from left to right and track potential collisions.

Because positions are unsorted, the first step is sorting robots by their position.

Then we simulate collisions using a stack:

Push robots moving Right (R) onto the stack.
When a robot moving Left (L) appears, it may collide with the latest R robot.
# Approach
1️⃣ Sort robots by position

We combine robot data:

(position, health, direction, original_index)

Then sort by position.

This ensures we process robots in the order they appear on the line.

2️⃣ Use a stack for Right-moving robots

When we encounter:

Robot moving Right (R)

Push its index into the stack.

R → stored as potential collider
Robot moving Left (L)

It may collide with robots in the stack.

While stack not empty:

compare healths

Three cases occur:

Case 1
Right health > Left health

Right survives:

right_health -= 1
left robot dies

Stop collision.

Case 2
Right health < Left health

Left survives:

left_health -= 1
right robot removed

Continue collision with next R robot.

Case 3
Right health == Left health

Both robots are destroyed.

Stop collision.

3️⃣ Collect survivors

After all collisions finish, collect robots with:

health > 0

Return them in the original input order.

# Complexity
## Time Complexity
1. O(n log n)
2. Sorting robots → O(n log n)
3. Collision simulation → O(n)
## Space Complexity
O(n)

For storing stack and robot metadata.

# Key Insight

The core trick is realizing:

Only R followed by L can collide

Which reduces a continuous physics simulation into a stack-based collision problem.

This pattern appears in many problems like:

1.asteroid collision
2.parentheses matching
3.monotonic stack simulations