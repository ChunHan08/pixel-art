class Tile
{
  int x, y;
  color colour;
  boolean spread;
  Tile(int x, int y, int color)
  {
    this.x = x;
    this.y = y;
    this.color = color;
    spread = false;
  }
  void Display()
  {
    fill(color);
    if (!show) noStroke();
    else stroke(180);
    rect(x * 20, y * 20, 20, 20);
  }
}
Tile[][] = new Tile[25][25];
color colors[] = {
  color(165, 42, 42),
  color(255, 0, 0),
  color(255, 165, 0),
  color(255, 255, 0),
  color(0, 255, 0),
  color(0, 0, 255),
  color(255, 0, 200),
  color(100),
  color(255)
};
color selected = color(255);
boolean show = true;
void setup()
{
  size(500, 500);
  for (int a = 0; a < grid.length; ++a)
  {
    for (int b = 0; b < grid[a].length; ++b)
      grid[a][b] = new Tile(a, b, color(100));
  }
}
void draw()
{
  for (int a = 0; a < grid.length; ++a)
  {
    for (int b = 0; b < grid[a].length; ++b)
      grid[a][b].Display();
  }
  if (show)
  {
    for (int a = 0; a < grid.length; ++a)
    {
      fill(colours[a]);
      stroke(0);
      ellipse(50, (a * 50) + 50, 30, 30);
    }
  }
  if (mousePressed && mouseButton == LEFT)
  {
    for (int a = 0; a < grid.length; ++a)
    {
      for (int b = 0; b < grid[a].length; ++b)
      {
        if (mouseX >= (b * 20) && mouseX <= 20 + (b * 20) && mouseY >= (a * 20) && mouseY <= 20 + (a * 20))
        {
          if (show)
          {
            for (int c = 0; c < colours.length; ++c)
            {
              if (dist(mouseX, mouseY, 50, (c * 50) + 50) <= 30)
                return;
            }
          }
          grid[b][a].color = selected;
        }
      }
    }
  }
}
void mousePressed()
{
  if (show)
  {
    for (int a = 0; a < colours.length; ++a)
    {
      if (dist(mouseX, mouseY, 50, (a * 50) + 50) <= 30)
        selected = colors[a];
    }
  }
}