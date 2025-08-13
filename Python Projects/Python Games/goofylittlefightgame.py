from direct.showbase.ShowBase import ShowBase
from panda3d.core import CardMaker, LVector3, LPoint3

class WalkablePlaneApp(ShowBase):
    def __init__(self):
        super().__init__()

        # Create a plane using CardMaker
        self.create_plane()

        # Add a controllable object (e.g., a ball)
        self.create_character()

        # Keyboard controls
        self.accept("arrow_up", self.move_character, [LVector3(0, 1, 0)])
        self.accept("arrow_down", self.move_character, [LVector3(0, -1, 0)])
        self.accept("arrow_left", self.move_character, [LVector3(-1, 0, 0)])
        self.accept("arrow_right", self.move_character, [LVector3(1, 0, 0)])

    def create_plane(self):
        # Create a flat plane
        cm = CardMaker("ground")
        cm.setFrame(-10, 10, -10, 10)  # Set size of the plane (x, y bounds)
        plane = self.render.attachNewNode(cm.generate())
        plane.setPos(0, 0, 0)  # Position plane at the origin
        plane.setHpr(0, -90, 0)  # Rotate to lie flat
        plane.setColor(0.5, 0.8, 0.5, 1)  # Add a greenish color

    def create_character(self):
        # Create a small sphere to represent the character
        self.character = self.loader.loadModel("models/smiley.egg")
        self.character.setScale(0.5)
        self.character.reparentTo(self.render)
        self.character.setPos(0, 0, 0.5)  # Start at the center of the plane

    def move_character(self, direction):
        # Move the character along the plane
        current_pos = self.character.getPos()
        new_pos = current_pos + direction
        # Limit movement to within the bounds of the plane
        new_pos.setX(max(-10, min(10, new_pos.x)))
        new_pos.setY(max(-10, min(10, new_pos.y)))
        self.character.setPos(new_pos)

if __name__ == "__main__":
    app = WalkablePlaneApp()
    app.run()
