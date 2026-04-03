import pygame
import sys
import random

pygame.init()

WIDTH = 1200
HEIGHT = 500
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Robot Collision Visual Simulator")

font = pygame.font.SysFont(None, 24)

# Input
positions = [3,5,2,6]
healths = [10,10,15,12]
directions = "RLRL"

scale = 120
speed = 1.5

robots = []
sparks = []

for i in range(len(positions)):
    robots.append({
        "id": i,
        "x": positions[i] * scale,
        "y": HEIGHT//2,
        "health": healths[i],
        "dir": directions[i],
        "alive": True
    })

clock = pygame.time.Clock()
timeline_speed = 1


class Spark:
    def __init__(self,x,y):
        self.x = x
        self.y = y
        self.vx = random.uniform(-3,3)
        self.vy = random.uniform(-3,3)
        self.life = 20

    def update(self):
        self.x += self.vx
        self.y += self.vy
        self.life -= 1

    def draw(self):
        pygame.draw.circle(screen,(255,200,0),(int(self.x),int(self.y)),3)


def draw_health_bar(robot):

    bar_width = 40
    bar_height = 6

    health_ratio = robot["health"]/20.0

    pygame.draw.rect(screen,(255,0,0),
        (robot["x"]-20,robot["y"]-35,bar_width,bar_height))

    pygame.draw.rect(screen,(0,255,0),
        (robot["x"]-20,robot["y"]-35,bar_width*health_ratio,bar_height))


def draw_robot(robot):

    if robot["dir"]=="R":
        color=(0,200,0)
    else:
        color=(200,0,0)

    pygame.draw.circle(screen,color,(int(robot["x"]),robot["y"]),18)

    text = font.render(str(robot["health"]),True,(255,255,255))
    screen.blit(text,(robot["x"]-8,robot["y"]-8))

    draw_health_bar(robot)


def move_robots():

    for r in robots:

        if not r["alive"]:
            continue

        if r["dir"]=="R":
            r["x"] += speed * timeline_speed
        else:
            r["x"] -= speed * timeline_speed


def collision_effect(x,y):

    for _ in range(15):
        sparks.append(Spark(x,y))


def handle_collisions():

    for i in range(len(robots)):
        for j in range(i+1,len(robots)):

            a=robots[i]
            b=robots[j]

            if not a["alive"] or not b["alive"]:
                continue

            if abs(a["x"]-b["x"])<30:

                if a["dir"]=="R" and b["dir"]=="L":

                    collision_effect((a["x"]+b["x"])/2,a["y"])

                    if a["health"]>b["health"]:
                        a["health"]-=1
                        b["alive"]=False

                    elif a["health"]<b["health"]:
                        b["health"]-=1
                        a["alive"]=False

                    else:
                        a["alive"]=False
                        b["alive"]=False


def update_sparks():

    for s in sparks[:]:
        s.update()
        if s.life<=0:
            sparks.remove(s)


def draw_sparks():

    for s in sparks:
        s.draw()


while True:

    for event in pygame.event.get():

        if event.type==pygame.QUIT:
            pygame.quit()
            sys.exit()

        if event.type==pygame.KEYDOWN:

            if event.key==pygame.K_UP:
                timeline_speed*=1.5

            if event.key==pygame.K_DOWN:
                timeline_speed/=1.5

    screen.fill((25,25,30))

    move_robots()

    handle_collisions()

    update_sparks()

    for r in robots:
        if r["alive"]:
            draw_robot(r)

    draw_sparks()

    info=font.render(
        f"Timeline Speed: {round(timeline_speed,2)}  (UP=Faster DOWN=Slower)",
        True,(255,255,255)
    )

    screen.blit(info,(20,20))

    pygame.display.update()

    clock.tick(60)