var
  i:Integer;
  f:text;

begin
  Assign(f,'rainbow.in');
  Rewrite(f);
  for i:=1 to 5000 do
    begin
      writeln(f,Random(i),i+random(100-i),i);
    end;
  Close(f);
end.
